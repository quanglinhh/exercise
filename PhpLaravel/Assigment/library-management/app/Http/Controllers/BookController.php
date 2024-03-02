<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Book;

class BookController extends Controller
{
    //
    public function index()
    {
        $books = Book::all();
        return view('books.index', compact('books'));
    }

    public function create()
    {
        return view('books.create');
    }


    public function store(Request $request)
        {
        $request->validate([
            'title'=> 'required',
            'isbn'=> 'required',
            'pub_year'=> 'required',
            'available'=> 'required',
            'authorid' => 'required',
        ]);

        Book::create($request->all());
        return redirect()->route('books.index')->with('success','Created Successfully.');
    }


    public function search(Request $request)
    {
        $search = $request -> search;
        $books = Book::where('title', 'like', "%$search%")->get();
        return view('books.index', compact('books'));
    }

}
