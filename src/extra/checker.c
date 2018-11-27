#include <dirent.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <unistd.h>
#include <signal.h>

#include "dup_finder.h"

int main(int argc, char* argv[]) {
	if (argc != 2) {
	printf("argcs %d\n", argc);
		exit(1);
	}
	FILE* f = fopen(argv[1], "r");
	int res = firstDup(f) >= 0;
	if (res) {
		kill(getppid(), SIGUSR1);
	}
	exit(res);
}

