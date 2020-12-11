组内排序
```sql
select id,@R:=case when @pid=TABLE_ID then @R+1 else 1 end,@pid:=TABLE_ID TABLEID from meta_column,(select @R:=0) a,(select @pid:=0) b order by id limit 100 

```
update和select结合使用
```sql
update A inner join(select id,name from B) c on A.id = c.id set A.name = c.name;
```
实战sql

给元数据未增加字段顺序的字段更新sql
```sql
update meta_column A inner join (
select id,@R:=case when @pid=TABLE_ID then @R+1 else 1 end SEQUENCE_NO,@pid:=TABLE_ID TABLEID from meta_column ,(select @R:=0) a,(select @pid:=0) b
where IS_DELETED <> 1

order by id -- limit 100 
) c on a.id = c.id set A.SEQUENCE_NO = c.SEQUENCE_NO;
```