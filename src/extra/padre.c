//#include <dirent.h>
//#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/wait.h>
#include <unistd.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>

int duplicati = 0;

void callback(int signal) {
	if (signal == SIGUSR1) {
		duplicati = 1;
	}
}

int main(int argc, char* argv[]) {
	signal(SIGUSR1, callback);
	int f = fork();
	if (!f) {
		execl("./checker.out", "checker", "nomi.txt", NULL);
		exit(1);
	}
	int status;
	waitpid(f, &status, 0);
	if (duplicati == 0) {
		printf("File senza duplicati.\n");
		exit(0);
	}
	f = fork();
	if (!f) {
		execl("./solver.out", "solver", "nomi.txt", NULL);
		exit(1);
	}
	waitpid(f, &status, 0);
	if (status != 0) {
		printf("Errore durante l'elaborazione.\n");
		exit(1);
	}
	printf("Duplicati rimossi.\n");
	exit(0);
}

