using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeLearn
{
    internal class Ex31
    {
        public static void RunCode()
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());
            bool result;
            if(a > b)
            {
                result = true;
                Console.WriteLine(result);
            }
            else if (a < b)
            {
                result = false;
                Console.WriteLine(result);
            }
            
        }
    }
}
