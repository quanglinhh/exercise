using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeLearn
{
    internal class Ex51
    {
      
       public static void RunCode()
        {
            int n = int.Parse(Console.ReadLine());
            int i = 1;
            int count = 0;
            while(i <= n)
            {
                if(n % i == 0)
                {
                    count++;
                }
                
                i++;
            }
            Console.WriteLine(count);
        }

    }   
}
