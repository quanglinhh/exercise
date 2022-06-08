using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeLearn
{
    internal class Ex63
    {
        public static void RunCode()
        {
            int n = int.Parse(Console.ReadLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
            {
                arr[i] = int.Parse(Console.ReadLine());
            }
            int sum = 0;
            for (int i = 0; i < arr.Length; i++)
            {
                if (arr[i]>0 && arr[i]% 2 != 0)
                {
                    sum += arr[i];
                }
            }
            Console.WriteLine(sum);          
        }
    }
}
