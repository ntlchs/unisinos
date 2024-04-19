// Created by: Davi de Lucca, Natália Chies e Victor Rosa

#include <math.h>
#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

#define THREADS 4

#define MAX_NUMBER 5000000

pthread_t tid[THREADS];

pthread_mutex_t lock_n;
int n = 1;

pthread_mutex_t lock_counter;
int counter = 0;

int isPrime(int n) {
    for (int i = 2; i <= sqrt(n); i++) {
        if (n % i == 0) {
            return 0;
        }
    }
    return 1;
}

void *checkPrime(void *vargp) {
    while (1) {
        int number;
        pthread_mutex_lock(&lock_n);
        if (n >= MAX_NUMBER) {
            pthread_mutex_unlock(&lock_n);
            break;
        }
        number = ++n;
        pthread_mutex_unlock(&lock_n);

        if (isPrime(number)) {
            pthread_mutex_lock(&lock_counter);
            counter++;
            pthread_mutex_unlock(&lock_counter);
        }
    }
    return NULL;
}

int main() {
    if (pthread_mutex_init(&lock_n, NULL) != 0) {
        printf("Mutex falhou na inicialização\n");
        return 1;
    }
    if (pthread_mutex_init(&lock_counter, NULL) != 0) {
        printf("Mutex falhou na inicialização\n");
        return 1;
    }

    for (int i = 0; i < THREADS; i++) {
        int error = pthread_create(&(tid[i]), NULL, &checkPrime, NULL);
        if (error != 0) {
            printf("Falha na criação da thread\n");
            return 1;
        }
    }

    for (int i = 0; i < THREADS; i++) {
        pthread_join(tid[i], NULL);
    }

    printf("%d primos menores que %d foram encontrados!\n", counter, n);

    pthread_mutex_destroy(&lock_n);
    pthread_mutex_destroy(&lock_counter);

    return 0;
}