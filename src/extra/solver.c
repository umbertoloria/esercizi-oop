#include <dirent.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <unistd.h>
#include <signal.h>

#include "dup_finder.h"

#define LIMIT 100

int main(int argc, char* argv[]) {
	FILE* f = fopen(argv[1], "r+");
	char c;
	int size;
	int times = 0;
	int first;
	while ((first = firstDup(f)) >= 0) {
		if (times >= LIMIT) {
			fclose(f);
			exit(1);
		}
		fseek(f, first, SEEK_SET);
		int length = -1;
		while (fscanf(f, "%c", &c) > 0) {
			if (length == -1 && c == '\n') {
				length = ftell(f) - 1 - first;
			}
		}
		int filelen = ftell(f);
		int bufsize = filelen - first - length - 1;
		int i;
		for (i = 0; i < bufsize; i++) {
			fseek(f, first + length + 1 + i, SEEK_SET);
			fread(&c, 1, 1, f);
			fseek(f, first + i, SEEK_SET);
			fwrite(&c, 1, 1, f);
		}
		ftruncate(fileno(f), filelen - length - 2);
		times++;
	}
	fclose(f);
	kill(getppid(), SIGUSR1);
	exit(0);
}

