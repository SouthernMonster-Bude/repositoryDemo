
items = ['java', 'vue', 'react', 'spring', 'springboot', 
        'springcloud', 'mysql', 'english', 'es6', 'python',
        'unity3d',"jvm","redis","mongodb","zookeeper",
        "dubbo","linux","nginx","shiro","ELK","C#",
        "docker"    
    ];
values = [937, 289, 140, 426, 369, 514, 498, 399, 61, 695, 300, 582, 804, 462, 389, 309, 292, 355, 726, 896,500,200];
itemsDatas=[];
for(let i=0;i<items.length;i++){
  let item = {value: values[i], name: items[i], selected: true};
  itemsDatas.push(item)
}

option = {
    title: {
        // text: '个人技能点',
        subtext: '2020年 个人技能点',
        right: 'leafDepth'
    },
    legend: {
        orient: 'vertical',
        left: 10,
        top:30,
        data: items
    },
    series: [
        {
            top:15,
            left: 180,
            name: '访问来源',
            type: 'pie',
            // selectedMode: 'single',
            radius: [0, '50%'],

            label: {
                //position: 'inner'
            },
            labelLine: {
                show: true
            },
            data: itemsDatas
        }
        
    ]
};