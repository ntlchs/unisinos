// Alunos: Natália Chies (1703007),

// Desenvolver um programa usando threads que calcule e mostre a quantidade de números primos
// existentes entre 1(um)e 5.000.000(cinco milhões). Para isso, você deve criar 4 threads. As
// threads deverão acessar uma variável global que indica qual é o próximo número para verificar
// se é primo ou não. Dica: qual é o nome dado ao trecho de código acessado pelas threads de forma
// concorrente ? Como gerenciar o acesso de modo a garantir exclusão mútua ?

#include <math.h>
#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

#define MAX_NUM 5000000
#define NUM_THREADS 4

pthread_mutex_t mutex;
int global_index = 2;  // Começa de 2, já que 1 não é primo
int total_primes = 0;

// Função para verificar se um número é primo
int is_prime(int n) {
    if (n <= 1) return 0;
    if (n <= 3) return 1;
    if (n % 2 == 0 || n % 3 == 0) return 0;
    for (int i = 5; i * i <= n; i += 6) {
        if (n % i == 0 || n % (i + 2) == 0) return 0;
    }
    return 1;
}

// Função executada por cada thread
void* worker(void* arg) {
    while (1) {
        int current_number;

        // Acesso exclusivo para ler e incrementar o índice global
        pthread_mutex_lock(&mutex);
        if (global_index > MAX_NUM) {
            pthread_mutex_unlock(&mutex);
            break;
        }
        current_number = global_index++;
        pthread_mutex_unlock(&mutex);

        if (is_prime(current_number)) {
            pthread_mutex_lock(&mutex);
            total_primes++;
            pthread_mutex_unlock(&mutex);
        }
    }
    return NULL;
}

int main() {
    pthread_t threads[NUM_THREADS];
    pthread_mutex_init(&mutex, NULL);

    // Criação das threads
    for (int i = 0; i < NUM_THREADS; i++) {
        pthread_create(&threads[i], NULL, worker, NULL);
    }

    // Espera todas as threads terminarem
    for (int i = 0; i < NUM_THREADS; i++) {
        pthread_join(threads[i], NULL);
    }

    printf("Total de números primos entre 1 e %d: %d\n", MAX_NUM, total_primes);

    pthread_mutex_destroy(&mutex);
    return 0;
}
