using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace dotNetCore.Models
{
    public class MovieContextCore : DbContext
    {
        public MovieContextCore()
        { }

        public MovieContextCore(DbContextOptions<MovieContextCore> options)
            : base(options)
        { }

        //Dbset
        public virtual DbSet<Movie> Movies { get; set; }

    }
}
