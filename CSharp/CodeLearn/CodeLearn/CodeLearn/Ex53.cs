using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeLearn
{
    internal class Ex53
    {
        public static void RunCode()
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());

            while(a <= b)
            {
                if (a % 3 == 0 && a % 5 == 0)
                {
                    Console.Write(a+" ");
                    
                }
                a++;
            }
        }
    }
}
