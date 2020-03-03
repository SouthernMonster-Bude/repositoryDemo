import pymysql

connect = pymysql.connect(host='localhost', user='root', password='123456root', port=3306, db='luckymoney')
cursor = connect.cursor()
cursor.execute('select * from luckymoney')
res = cursor.fetchone()
print(res)
res = cursor.fetchone()
print(res)
res = cursor.fetchone()
print(res)
