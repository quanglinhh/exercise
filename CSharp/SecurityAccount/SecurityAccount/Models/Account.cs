using System;
using System.Collections.Generic;

namespace SecurityAccount.Models;

public partial class Account
{
    public int Id { get; set; }

    public string? Username { get; set; }

    public string? Password { get; set; }
}
