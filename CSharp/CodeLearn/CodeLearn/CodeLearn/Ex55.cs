using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeLearn
{
    internal class Ex55
    {
        public static void RunCode()
        {
            for (int i = 1; i <= 100; i++)
            {
                if( i %2 == 0)
                {
                    continue;
                }
				Console.Write(i + " ");
            }
        }
    }
}
