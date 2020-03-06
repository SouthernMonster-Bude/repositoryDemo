
# 如果写入文件不存在，open（）将自动创建它
# 如果文件已存在已有内容，会清空再写入
filename = 'test_text.txt'
with open(filename, 'w') as file_object:
    file_object.write("Add a word")


filename = 'test_text.txt'
with open(filename, 'w') as file_object:
    file_object.write("Add a word/n")
    file_object.write("Add two words/n")
# 在原有文件上添加内容
filename = 'test_text.txt'
with open(filename, 'a') as file_object:
    file_object.write("lalala/n")
    file_object.write("hahaha/n")