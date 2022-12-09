using System;
using System.Collections.Generic;

#nullable disable

namespace coreShoppingCart.Models
{
    public partial class Role
    {
        public Role()
        {
            UserRoleMappings = new HashSet<UserRoleMapping>();
        }

        public int Id { get; set; }
        public string RoleName { get; set; }

        public virtual ICollection<UserRoleMapping> UserRoleMappings { get; set; }
    }
}
