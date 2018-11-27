#include "dup_finder.h"

int firstDup(FILE* f) {
	fseek(f, 0, SEEK_SET);
	char c;
	int is, ie;
	int js, je;
	char* searching = 0;
	char str[50];
	int filesize = getSize(f);
	is = 0;
	while (fread(&c, 1, 1, f) > 0) {
		if (!searching) {
			if (c == '\n') {
				ie = ftell(f) - 1;
				// printf("1 (%d-%d) %s\n", is, ie, pr(f, is, ie));
				searching = pr(f, is, ie);
				js = ie + 1;
			}
		} else if (searching) {
			if (c == '\n') {
				je = ftell(f) - 1;
				if (strcmp(searching, pr(f, js, je)) == 0) {
					// printf("DUP %s %s\n", searching, pr(f, js, je));
					return js;
				}
				if (je >= filesize - 1) {
					free(searching);
					searching = 0;
					is = ie + 1;
					fseek(f, is, SEEK_SET);
				} else {
					js = je + 1;
				}
			}
		}
	}
	return -1;
}

int getSize(FILE* file) {
	int oldOff = ftell(file);
	fseek(file, 0, SEEK_END);
	int res = ftell(file);
	fseek(file, oldOff, SEEK_SET);
	return res;
}

char* pr(FILE* file, int start, int end) {
	int oldOff = ftell(file);
	int i;
	char* str = (char*) malloc(50);
	fseek(file, start, SEEK_SET);
	for (i = start; i < end; i++) {
		fread(&str[i-start], 1, 1, file);
	}
	str[i-start] = '\0';
	fseek(file, oldOff, SEEK_SET);
	return str;
}

