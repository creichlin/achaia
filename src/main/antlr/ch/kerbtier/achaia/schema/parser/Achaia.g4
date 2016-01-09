grammar Achaia;

root            : entity+;

entity          : identifier ':'  type;


type            : string | user | date | integer | slug | blob | list | map;

string          : STRING;

slug            : SLUG;

user            : USER;

date            : DATE;

blob            : BLOB;

integer         : INTEGER;

list            : '[' type ']';

map             : '{' entity+ '}';


identifier        : IDENTIFIER | STRING | USER | DATE | INTEGER | SLUG | BLOB;

STRING            : 'string';

SLUG              : 'slug';

USER              : 'user';

DATE              : 'date';

INTEGER           : 'integer';

BLOB              : 'blob';

IDENTIFIER        : [A-Za-z] ([A-Za-z0-9_])+;

BLOCK_COMMENT     : '/*' .*? '*/' -> skip;
EOL_COMMENT       : '//' ~[\r\n]* -> skip;

WS                : [ \n\t\r]+ -> skip;

