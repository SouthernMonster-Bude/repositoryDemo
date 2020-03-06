
# principal = 10000
# interest = 970
# days = 365
principal = 45000
interest = 9000
days = 365*2
# 年利率=(Interest ÷ principal ÷ days)×365×100%=4.745%
formula = interest / principal / days * 100

print('利率为%f%', formula*days)
print('年利率为%f%', formula*365)
print('月利率为%f%', formula*30)
print('日利率为%f%', formula)
