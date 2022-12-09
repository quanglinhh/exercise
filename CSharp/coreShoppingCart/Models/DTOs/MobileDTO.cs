using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace coreShoppingCart.Models.DTOs
{
    public class MobileDTO
    {
        public int? slno { get; set; }
        public string MobileName { get; set; }
        public Nullable<decimal> Price { get; set; }
        public string Url { get; set; }
        public string Features { get; set; }
        public string model { get; set; }
        public string color { get; set; }

        public string SimType { get; set; }
    }
}
