%{
#include <stdio.h>
#include <stdlib.h>
int errorFlag=0;
int yylex();
void yyerror(const char *s);
%}

%token NUMBER
%left '+' '-'
%left '*' '/'

%%

input:
      | input  line
;

line:
        expression '\n' {
                            if(errorFlag) errorFlag=0;
                            else printf("%d\n", $1);

                        }
;


expression:
        NUMBER                          {$$ = $1;}
        | expression '+' expression     {$$ = $1 + $3;}
        | expression '-' expression     {$$ = $1 - $3;}
        | expression '*' expression     {$$ = $1 * $3;}
        | expression '/' expression     {
                                            if($3==0){
                                                 yyerror("You can't divide by Zero!");
                                                 errorFlag=1;
                                                 $$ = 0;
                                            }
                                            else $$ = $1/$3;
                                        }
        | '(' expression ')'            {$$ = $2;}
;
%%

void yyerror(const char *s){
    fprintf(stderr, "Error: %s\n", s);
}

int main(){
    printf("Enter expression:\n");
    yyparse();
    return 0;
}
