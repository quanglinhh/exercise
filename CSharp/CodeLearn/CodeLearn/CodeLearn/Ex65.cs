using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeLearn
{
    internal class Ex65
    {
        public static void RunCode()
        {
            int n = int.Parse(Console.ReadLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
            {
                arr[i] = int.Parse(Console.ReadLine());
            }
            for (int i = 0; i < n; i++)
            {
                for(int j = i+1; j < n; j++)
                {
                    if(arr[i] > arr[j])
                    {
                        int a = arr[i];
                        arr[i] = arr[j];
                        arr[j] = a;
                    }
                }  
            }
            for(int i = 0; i < n; i++)
            {
                Console.Write(arr[i]+" ");
            }
        }
    }
}
