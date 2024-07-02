#include <stdio.h>

#define MAZE_HEIGHT 4
#define MAZE_WIDTH 4
#define X_POS 1
#define Y_POS 2

int exit_maze(char maze[MAZE_HEIGHT][MAZE_WIDTH], int xpos, int ypos);

int main(void) {
    char maze[MAZE_HEIGHT][MAZE_WIDTH] = {
        {' ', 'X', 'X', ' '},
        {'X', ' ', ' ', 'X'},
        {' ', ' ', 'X', ' '},
        {'E', 'X', ' ', ' '}
    };
    int xpos = X_POS;
    int ypos = Y_POS;

    exit_maze(maze, xpos, ypos);

}

int exit_maze(char maze[MAZE_HEIGHT][MAZE_WIDTH], int xpos, int ypos) {
    if (xpos < 0 || xpos >= MAZE_HEIGHT || ypos < 0 || ypos >= MAZE_WIDTH)
        return 0;
    
    if (maze[xpos][ypos] == 'E') {
        puts("Find out Exit!\n");
        return 1;
    }
    
    if(maze[xpos][ypos] != ' ')
        return 0;
    
    maze[xpos][ypos] = 'V';

    if (exit_maze(maze, xpos + 1, ypos))
    {
        maze[xpos][ypos] = 'P';//test                                            
        printf("Go Down from maze[%d][%d]\n", xpos, ypos);   //test                                     
        return 1;   //test                                     
    }
    if (exit_maze(maze, xpos, ypos + 1))
    {
        maze[xpos][ypos] = 'P';
        printf("Go Right from maze[%d][%d]\n", xpos, ypos);
        return 1;
    }
    if (exit_maze(maze, xpos - 1, ypos))
    {
        maze[xpos][ypos] = 'P';
        printf("Go Up from maze[%d][%d]\n", xpos, ypos);
        return 1;
    }
    if (exit_maze(maze, xpos, ypos - 1))
    {
        maze[xpos][ypos] = 'P';
        printf("Go Left from maze[%d][%d]\n", xpos, ypos);
        return 1;
    }

    return 0;
}