package com.example.stickerly.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stickerly.Model.ArtistsModel
import com.example.stickerly.Model.CategoryModel
import com.example.stickerly.Model.StickerModel
import com.example.stickerly.Model.StickerPlusModel
import com.example.stickerly.Model.SuggestedModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainViewModel(): ViewModel() {
    private val firebaseDatabase=FirebaseDatabase.getInstance()
    private val _category=MutableLiveData<List<CategoryModel>>()
    private val _sticker=MutableLiveData<List<StickerModel>>()
    private val _suggested=MutableLiveData<List<SuggestedModel>>()
    private val _stickerSecond=MutableLiveData<List<StickerModel>>()
    private val _searchTrending=MutableLiveData<List<CategoryModel>>()
    private val _searchSuggested=MutableLiveData<List<SuggestedModel>>()
    private val _artists=MutableLiveData<List<ArtistsModel>>()
    private val _plus=MutableLiveData<List<StickerPlusModel>>()


    val categorys:LiveData<List<CategoryModel>> =_category
    val stickers:LiveData<List<StickerModel>> =_sticker
    val suggested:LiveData<List<SuggestedModel>> =_suggested
    val stickerSecond:LiveData<List<StickerModel>> = _stickerSecond
    val searchTrending:LiveData<List<CategoryModel>> =_searchTrending
    val searchSuggested:LiveData<List<SuggestedModel>> =_searchSuggested
    val artists:LiveData<List<ArtistsModel>> =_artists
    val plus:LiveData<List<StickerPlusModel>> =_plus


    fun loadCategory(){
        val ref=firebaseDatabase.getReference("Category")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists= mutableListOf<CategoryModel>()
                for (chilSnapshot in snapshot.children){
                    val list=chilSnapshot.getValue(CategoryModel::class.java)
                    if (list!=null)
                    {
                        lists.add(list)
                    }
                }
                _category.value=lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }


    fun loadSticker(){
        val ref=firebaseDatabase.getReference("Emoji")
        ref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists= mutableListOf<StickerModel>()
                for (chilSnapShot in snapshot.children){
                    val list=chilSnapShot.getValue(StickerModel::class.java)
                    if (list!=null){
                        lists.add(list)
                    }
                }
                _sticker.value=lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

    }

    fun loadSuggested(){
        val ref=firebaseDatabase.getReference("Suggested")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists= mutableListOf<SuggestedModel>()
                for (chilSnapShot in snapshot.children){
                    val list=chilSnapShot.getValue(SuggestedModel::class.java)
                    if (list!=null){
                        lists.add(list)
                    }
                }
                _suggested.value=lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

    fun loadStickerSecond(){
        val ref=firebaseDatabase.getReference("EmojiSecond")
        ref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists= mutableListOf<StickerModel>()
                for (childrenSnapShot in snapshot.children){
                    val list=childrenSnapShot.getValue(StickerModel::class.java)
                    if (list!=null){
                        lists.add(list)
                    }
                }
                _stickerSecond.value=lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
    fun loadSearchTrending(){
        val ref=firebaseDatabase.getReference("SearchTrending")
        ref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists= mutableListOf<CategoryModel>()
                for (childrenSnapShot in snapshot.children){
                    val list=childrenSnapShot.getValue(CategoryModel::class.java)
                    if (list!=null){
                        lists.add(list)
                    }
                }
                _searchTrending.value=lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
    fun loadSearchSuggested(){
        val ref=firebaseDatabase.getReference("SearchSuggested")
        ref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists= mutableListOf<SuggestedModel>()
                for (childrenSnapshot in snapshot.children){
                    val list=childrenSnapshot.getValue(SuggestedModel::class.java)
                    if (list!=null){
                        lists.add(list)
                    }
                }
                _searchSuggested.value=lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
     fun loadArtists(){
         val ref=firebaseDatabase.getReference("Artists")
         ref.addValueEventListener(object :ValueEventListener{
             override fun onDataChange(snapshot: DataSnapshot) {
                 val lists= mutableListOf<ArtistsModel>()
                 for (childrenSnapshot in snapshot.children)
                 {
                     val list=childrenSnapshot.getValue(ArtistsModel::class.java)
                     if (list!=null){
                         lists.add(list)
                     }
                 }
                 _artists.value=lists
             }

             override fun onCancelled(error: DatabaseError) {
                 TODO("Not yet implemented")
             }
         })
     }

    fun loadStickerPlus(){
        val ref=firebaseDatabase.getReference("StickerPlus")
        ref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists= mutableListOf<StickerPlusModel>()
                for (childrenSnapshot in snapshot.children)
                {
                    val list=childrenSnapshot.getValue(StickerPlusModel::class.java)
                    if (list!=null){
                        lists.add(list)
                    }
                }
                _plus.value=lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

}