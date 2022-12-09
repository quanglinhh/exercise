using System;
using System.Collections.Generic;
using JwtApiSample.Models;
using Microsoft.EntityFrameworkCore;

namespace JwtApiSample.Models
{
    public partial class Product
    {
        public int ProductId { get; set; }
        public string Name { get; set; } = null!;
        public string? Category { get; set; }
        public string? Color { get; set; }
        public decimal UnitPrice { get; set; }
        public int AvailableQuantity { get; set; }
    }


public static class ProductEndpoints
{
	public static void MapProductEndpoints (this IEndpointRouteBuilder routes)
    {
        routes.MapGet("/api/Product", async (JwtApiContext db) =>
        {
            return await db.Products.ToListAsync();
        })
        .WithName("GetAllProducts");

        routes.MapGet("/api/Product/{id}", async (int ProductId, JwtApiContext db) =>
        {
            return await db.Products.FindAsync(ProductId)
                is Product model
                    ? Results.Ok(model)
                    : Results.NotFound();
        })
        .WithName("GetProductById");

        routes.MapPut("/api/Product/{id}", async (int ProductId, Product product, JwtApiContext db) =>
        {
            var foundModel = await db.Products.FindAsync(ProductId);

            if (foundModel is null)
            {
                return Results.NotFound();
            }
            //update model properties here

            await db.SaveChangesAsync();

            return Results.NoContent();
        })   
        .WithName("UpdateProduct");

        routes.MapPost("/api/Product/", async (Product product, JwtApiContext db) =>
        {
            db.Products.Add(product);
            await db.SaveChangesAsync();
            return Results.Created($"/Products/{product.ProductId}", product);
        })
        .WithName("CreateProduct");


        routes.MapDelete("/api/Product/{id}", async (int ProductId, JwtApiContext db) =>
        {
            if (await db.Products.FindAsync(ProductId) is Product product)
            {
                db.Products.Remove(product);
                await db.SaveChangesAsync();
                return Results.Ok(product);
            }

            return Results.NotFound();
        })
        .WithName("DeleteProduct");
    }
}}
