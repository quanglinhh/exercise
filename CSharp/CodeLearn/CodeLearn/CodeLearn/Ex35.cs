using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeLearn
{
    internal class Ex35
    {
        public static void RunCode()
        {
            string a = Console.ReadLine();
            string b = Console.ReadLine();
            if(a == b)
            {
                Console.WriteLine("two people have the same name");
            }
            else
            {
                Console.WriteLine("two people don't have the same name"); 
            }
        }
    }
}
