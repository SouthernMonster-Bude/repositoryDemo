using System;

namespace FunStru
{
    class Program
    {
        static void Main(string[] args)
        {
            /* Console.WriteLine("Hello World!");*/
            Console.WriteLine("请输入一个值");
            string ins = Console.ReadLine();
            Console.WriteLine("计算结果是");
            Console.WriteLine(AddNumber(Convert.ToInt32(ins)));
            Console.ReadKey();

        }

        static int AddNumber(int i)
        {
            if (i < 1) return 0;
            return i + AddNumber(i - 1);
        }






        //声明一个自我介绍的函数
        static void Hello()
        {
            Console.WriteLine("大家好，我是XXX");
        }
    }
}
