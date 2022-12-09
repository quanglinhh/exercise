using Microsoft.EntityFrameworkCore.Migrations;

namespace dotNetCore.Migrations
{
    public partial class AddMovieDescription : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<string>(
                name: "Description",
                table: "Movies",
                type: "nvarchar(255)",
                nullable: true);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "Description",
                table: "Movies");
        }
    }
}
