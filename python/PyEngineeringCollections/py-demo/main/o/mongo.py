import pymongo

client = pymongo.MongoClient('localhost')
db = client['local']
db['table'].insert({'name':'walker'})
res = db['table'].find_one({'name':'walker'})
print(res)
