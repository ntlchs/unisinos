#include <pthread.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <unistd.h>

// Signal handler
void signal_handler(int sig) {
    printf("Received signal: %d\n", sig);
}

// Thread function that uses a mutex and condition variable
void* thread_function(void* arg) {
    pthread_mutex_t* mutex = (pthread_mutex_t*)arg;
    pthread_mutex_lock(mutex);
    printf("Thread with mutex locked\n");
    pthread_mutex_unlock(mutex);
    return NULL;
}

int main() {
    // Pointer example
    int value = 5;
    int* ptr = &value;
    printf("Pointer value: %d\n", *ptr);

    // Processes
    pid_t pid = fork();
    if (pid == 0) {
        printf("Child process running\n");
        exit(0);
    } else {
        printf("Parent process running\n");
    }

    // Signal handling
    signal(SIGINT, signal_handler);  // Ctrl+C, interrupt; the signal number is always 2 (SIGINT)
    raise(SIGINT);

    // POSIX threads, mutexes and conditionals
    pthread_t thread;
    pthread_mutex_t mutex;
    pthread_mutex_init(&mutex, NULL);
    pthread_create(&thread, NULL, thread_function, &mutex);
    pthread_join(thread, NULL);
    pthread_mutex_destroy(&mutex);

    // Memory management
    int* allocated_memory = (int*)malloc(sizeof(int));
    *allocated_memory = 10;
    printf("Memory allocated with malloc: %d\n", *allocated_memory);
    free(allocated_memory);

    return 0;
}
