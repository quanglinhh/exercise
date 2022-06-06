using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeLearn
{
    internal class Ex57
    {
        public static void RunCode()
        {
            int i = 1;
            do
            {
                if(i %10 == 0)
                {
                    Console.Write(i+ " ");
                }
                i++;
			} while (i <= 1000);
        }
    }
}
