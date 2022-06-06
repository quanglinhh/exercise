using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeLearn
{
    internal class Ex43
    {
        public static void RunCode()
        {
            int n = int.Parse(Console.ReadLine());
            for (int i = n; i <= -n; i--)
            {
                Console.Write(i+ " ");
            }
        }
    }
}
