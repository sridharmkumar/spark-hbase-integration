# spark-hbase-integration

HBase Table Creation:
1. Goto HBase Shell 
2. Execute the below mentioned commands
create_namespace 'myspace'
create 'myspace:customer', 'personal'
put 'myspace:customer','1','personal:firstname', 'Aathavan'
put 'myspace:customer','1','personal:lastname', 'Aaruuran'
put 'myspace:customer','1','personal:age', '35'
scan 'myspace:customer'