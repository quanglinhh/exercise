using coreShoppingCart.Models.DTOs;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ShoppingMobile1.Models
{
    public class MobileItem
    {
        public int slNo { get; set; }
        public string MobileName { get; set; }
        public Nullable<decimal> Price { get; set; }
        public string url { get; set; }
        public string Description { get; set; }
        public string ZoomUrl { get; set; }

        public int count { get; set; }

        public MobileItem(MobileDTO mo)
        {
            this.slNo = mo.slno.HasValue ? mo.slno.Value : 0;
            this.MobileName = mo.MobileName;
            this.url = mo.Url;
            this.count = 1;
        }
    }
}
