<?php

namespace App\Http\Controllers;
use App\Models\Product;
use Illuminate\Http\Request;
use php_user_filter;
use PhpParser\Node\Stmt\Global_;

class ProductController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Contracts\Foundation\Application|\Illuminate\Contracts\View\Factory|\Illuminate\Contracts\View\View
     */
    public function index()
    {
        //
        //paging
         $products = product::latest()->paginate(5);
        return view('products.index',compact('products'))->with('i',
            (request()->input('page', 1) - 1) * 5);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Contracts\Foundation\Application|\Illuminate\Contracts\View\Factory|\Illuminate\Contracts\View\View
     */
    public function create()
    {
        //
        return view('products.create');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\RedirectResponse
     */
    public function store(Request $request)
    {
        //
        $request->validate([
            'product_name'=> 'required',
            'product_desc'=> 'required',
            'product_qty'=> 'required',

        ]);

        product::create($request->all());
        return redirect()->route('products.index')->with('success','Created Successfully.');
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Contracts\Foundation\Application|\Illuminate\Contracts\View\Factory|\Illuminate\Contracts\View\View
     */
    public function show(product $product)
    {
        //
        return view('products.show', compact('product'));
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Contracts\Foundation\Application|\Illuminate\Contracts\View\Factory|\Illuminate\Contracts\View\View
     */
    public function edit(product $product)
    {
        //
        return view('products.edit',compact('product'));
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\RedirectResponse
     */
    public function update(Request $request, product $product)
    {
        //
        $request->validate([
            'product_name'=> 'required',
            'product_desc'=> 'required',
            'product_qty'=> 'required',

        ]);

        $product->update($request->all());
        return redirect()->route('products.index')->with('success','Created Successfully.');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param int $id
     * @param $product
     * @return \Illuminate\Http\RedirectResponse
     */
    public function destroy(product $product)
    {
        //
        $product->delete();
        return redirect()->route('products.index')->with('success','Created Successfully.');
    }
}
