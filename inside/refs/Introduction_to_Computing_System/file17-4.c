#include <stdio.h>

void MoveDisk(int disk_number, int start_post, int end_post, int mid_post);

int main(void) {
    int disk_number = 3;
    int start_post = 1;
    int end_post = 3;
    int mid_post = 2;
    MoveDisk(3, 1, 3, 2);
}
// disk_number is the disk to be moved(disk1 is smallest)
// start_post is the post that the disk is currently on
// end_post is the post we want the disk to end on
// mid_post is the intermediate post
void MoveDisk(int disk_number, int start_post, int end_post, int mid_post) {
    if (disk_number > 1) {
        // Move n-1 disks off the current disk on
        // start_post and put them on the mid_post
        MoveDisk(disk_number -1, start_post, mid_post, end_post);
        printf("Move disk %d from post %d to post %d. \n", disk_number, start_post, end_post);
        MoveDisk(disk_number -1, mid_post, end_post, start_post);
    } else {
        printf("Move disk 1 from post %d to post %d.\n", start_post, end_post);
    }
}