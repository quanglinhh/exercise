using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeLearn
{
    internal class Ex39
    {
        public static void RunCode()
        {
            int score = int.Parse(Console.ReadLine());
            if (score >= 0 && score <= 10)
            {
                Console.WriteLine("The score is valid");
            }
            else
            {
                Console.WriteLine("The score is not valid");
            }
        }
    }
}
