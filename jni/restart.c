#include <stdio.h>
#include <errno.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char **argv)
{
	if (daemon(0, 0) < 0) {
		perror("daemon");
		return -errno;
	}
	system("stop");
	system("start");
	return 0;
}
