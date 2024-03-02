<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('books', function (Blueprint $table) {
            $table->id('bookid');
            $table->unsignedBigInteger('authorid');
            $table->string('title');
            $table->string('ISBN')->unique();
            $table->smallInteger('pub_year');
            $table->tinyInteger('available')->default(1);
            $table->timestamps();

           // $table->foreign('authorid')->references('id')->on('authors');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('books');
    }
};
