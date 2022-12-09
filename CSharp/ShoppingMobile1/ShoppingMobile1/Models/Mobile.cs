

namespace ShoppingMobile1.Models
{
    public partial class Mobile
    {
        public Mobile()
        {
            MobileDetails = new HashSet<MobileDetail>();
        }

        public int SlNo { get; set; }
        public string MobileName { get; set; }
        public decimal? Price { get; set; }
        public string Url { get; set; }
        public string? Description { get; set; }
        public string? ZoomUrl { get; set; }

        public virtual ICollection<MobileDetail> MobileDetails { get; set; }
    }


}
