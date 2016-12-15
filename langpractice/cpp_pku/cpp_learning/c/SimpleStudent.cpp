#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define MAXLINE 100
#define NNAME    20
#define NID     10
#define YEARS   4

class Student {
public:
    Student();
private:
    char name[NNAME], id[NID];
    int age, grade[YEARS], ave_g;
    void getInfo();
    void getAve();
    void showInfo();
};

Student::Student() {
    age = ave_g = 0;
    for (int i = 0; i < NNAME; ++i)  name[i] = '\0';
    for (int i = 0; i < NID;   ++i)    id[i] = '\0';
    for (int i = 0; i < YEARS; ++i) grade[i] = 0;
    
    getInfo(); getAve(); showInfo();
}

void Student::getInfo() {
/*  ? no good
    scanf("%s,%d,%s,%d,%d,%d,%d", 
        name, &age, id, &grade[0], &grade[1], &grade[2], &grade[3]);
*/
    
    char str[MAXLINE];
    scanf("%s", str);
    char *p = strtok(str, ",");
    strcpy(name, p);
    p = strtok(NULL, ",");
    age = atoi(p);
    p = strtok(NULL, ",");
    strcpy(id, p);
    p = strtok(NULL, ",");
    grade[0] = atoi(p);
    p = strtok(NULL, ",");
    grade[1] = atoi(p);
    p = strtok(NULL, ",");
    grade[2] = atoi(p);
    p = strtok(NULL, ",");
    grade[3] = atoi(p);

}

void Student::getAve() {
    int sum = 0;
    for (int i = 0; i < YEARS; ++i) sum += grade[i];
    ave_g = sum / YEARS;
}

void Student::showInfo() {
/*
    printf("%s\n", name    );
    printf("%d\n", age     );
    printf("%s\n", id      );
    printf("%d\n", ave_g   );
    printf("%d\n", grade[0]);
    printf("%d\n", grade[1]);
    printf("%d\n", grade[2]);
    printf("%d\n", grade[3]);
*/
    printf("%s,%d,%s,%d\n", name, age, id, ave_g);
}

int main() {
    Student *s = new Student();
    delete s;

return 0;
}
    
