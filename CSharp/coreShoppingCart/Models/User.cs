using System;
using System.Collections.Generic;

#nullable disable

namespace coreShoppingCart.Models
{
    public partial class User
    {
        public User()
        {
            UserRoleMappings = new HashSet<UserRoleMapping>();
        }

        public int Id { get; set; }
        public string Username { get; set; }
        public string Password { get; set; }

        public virtual ICollection<UserRoleMapping> UserRoleMappings { get; set; }
    }
}
