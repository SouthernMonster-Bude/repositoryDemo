using System;
using System.Diagnostics;
using System.Text;
using System.Threading.Tasks;
namespace TimeTest
{
    class Program
    {
        static void Main(string[] args)
        {
            Stopwatch sw = new Stopwatch();
            sw.Start();
            string s = "";
            for(int i = 0; i < 300000; i++)
            {
                s += i;
            }
            sw.Stop();
            Console.WriteLine("string use time "+sw.Elapsed);
            sw.Reset();
            sw.Start();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 300000; i++)
            {
                sb.Append(i);
            }
            sw.Stop();
            Console.WriteLine("stringbuilder use time "+sw.Elapsed);
        }
    }
}
