#include <math.h>
#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

// Number of threads for parallel prime number search
#define THREADS 4
// Maximum number up to which to check for primes
#define MAX_NUMBER 5000000

// Thread identifiers array
pthread_t tid[THREADS];

// Mutexes for thread-safe operations on shared variables
pthread_mutex_t lock_n;  // Mutex for current number being checked
int n = 1;               // Shared variable to keep track of the current number being checked

pthread_mutex_t lock_counter;  // Mutex for prime count
int counter = 0;               // Shared variable to count the number of primes found

// Function to check if a number is prime
// Returns 1 if prime, 0 otherwise
int isPrime(int n) {
    for (int i = 2; i <= sqrt(n); i++) {
        if (n % i == 0) {
            return 0;  // Not a prime number
        }
    }
    return 1;  // Is a prime number
}

// The function each thread executes to find prime numbers
void *checkPrime(void *vargp) {
    while (n < MAX_NUMBER) {
        int number;
        // Lock to safely update the current number being checked
        pthread_mutex_lock(&lock_n);
        number = ++n;                   // Increment and get the current number
        pthread_mutex_unlock(&lock_n);  // Unlock after update

        if (isPrime(number)) {
            // Lock to safely update the prime counter
            pthread_mutex_lock(&lock_counter);
            counter++;                                                        // Increment prime count
            printf("Prime found: %d (Total primes: %d)\n", number, counter);  // Prime number found and total count
            pthread_mutex_unlock(&lock_counter);                              // Unlock after update
        }
    }
    return NULL;  // Standard for pthread functions, indicating completion
}

int main() {
    // Initialize mutexes; exit with failure if initialization fails
    if (pthread_mutex_init(&lock_n, NULL) != 0 || pthread_mutex_init(&lock_counter, NULL) != 0) {
        printf("Mutex initialization failed\n");
        return 1;  // Indicate failure to initialize mutexes
    }

    printf("Starting prime number search with %d threads...\n", THREADS);

    // Create threads to start prime number search
    for (int i = 0; i < THREADS; i++) {
        int error = pthread_create(&(tid[i]), NULL, &checkPrime, NULL);
        if (error != 0) {
            printf("Failed to create thread\n");
            return 1;  // Indicate failure to create thread
        }
    }

    // Wait for all threads to finish execution
    for (int i = 0; i < THREADS; i++) {
        pthread_join(tid[i], NULL);
    }

    // Output the total count of prime numbers found
    printf("%d primes less than %d were found!\n", counter, n);

    // Destroy mutexes to free allocated resources
    pthread_mutex_destroy(&lock_n);
    pthread_mutex_destroy(&lock_counter);

    return 0;  // Indicate successful execution
}
