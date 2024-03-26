#include <stdio.h>      // for printf
#include <sys/types.h>  // for pid_t
#include <sys/wait.h>   // for wait
#include <unistd.h>     // for fork, getpid, getppid, execl

void printMatrix(int matrix[10][10]) {
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            printf("%2d  ", matrix[i][j]);
            // "%2d  :" print integer with at least 2 characters (right-justified if 1 character only), followed by 2 spaces
            // this way, the matrix is aligned
        }
        printf("\n");
    }
}

int main() {
    printf("\nI'm the original process before fork. PID: %d\n", getpid());

    printf("\nI'll create a 10x10 matrix and transpose it.\n");

    int matrix[10][10];

    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            matrix[i][j] = i * 10 + j;
            // i * 10: multiplies the line index (i), generating multiples of 10 (0, 10, 20, 30, ..., 90)
            // + j: adds the column index (j) to the previous result, generating the numbers from 0 to 9 for each position in line
        }
    }

    printf("\n10x10 Matrix:\n");
    printMatrix(matrix);

    // transpose the matrix
    int temp;  // create temp to store value of matrix[i][j], since it will be overwritten
    for (int i = 0; i < 10; i++) {
        for (int j = i + 1; j < 10; j++)  // starts at i + 1 because diagonal elements (j = i) remain the same
        {
            temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }

    printf("\nTransposed 10x10 Matrix:\n");
    printMatrix(matrix);

    printf("\nNow, I'll fork to create a child process.\n");

    pid_t pid;

    pid = fork();

    if (pid < 0) {
        printf("Fork Failed\n");

        return 1;

    } else if (pid == 0) {
        printf("\nI'm the child process. PID: %d, Parent PID: %d\n", getpid(), getppid());

        printf("\nNow I'll count the number of times the word 'Gaza' appears in the Al Jazeera website:\n");

        execl("/bin/sh", "sh", "-c", "curl -s https://www.aljazeera.com/ | grep -io 'gaza' | wc -l", NULL);
        // execl: execute a list of arguments
        // /bin/sh: shell to execute the command
        // "sh": name of the shell
        // -c: option to execute the command
        // curl -s: silent mode, to avoid progress meter
        // grep -io: global regex print, -i ignore case and -o only print the matching part of the line, so the process will be faster
        // wc -l: wordcount, -l count the number of lines
        // | (pipe): sends the output of the previous command as input to the next command
        // NULL: end of arguments

        printf("\nThis line won't be executed, unless execl fails.\n");
    } else {
        printf("\nAfter fork, my PID: %d, Child PID: %d\n", getpid(), pid);

        printf("\nNow, I'll wait for the child to complete.\n");

        wait(NULL);

        printf("\nI'm the parent process after wait, child process is now complete.\n");
    }

    return 0;
}
