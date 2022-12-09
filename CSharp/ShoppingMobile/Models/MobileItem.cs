using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ShoppingMobile.Models
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

        public MobileItem(Mobile mo)
        {
            this.slNo = mo.slNo;
            this.MobileName = mo.MobileName;
            this.url = mo.url;
            this.count = 1;
        }
    }
}