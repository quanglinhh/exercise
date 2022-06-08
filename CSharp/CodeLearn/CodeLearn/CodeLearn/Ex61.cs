using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeLearn
{
    internal class Ex61
    {
        public static void RunCode()
        {
            int n = int.Parse(Console.ReadLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
            {
                arr[i] = int.Parse(Console.ReadLine());
            }
            for (int i = 0; i< n; i++)
            {
                if (arr[i] % 2 == 0)
                {
                    Console.Write(arr[i]+" ");
                }
            }
        }
    }
}
