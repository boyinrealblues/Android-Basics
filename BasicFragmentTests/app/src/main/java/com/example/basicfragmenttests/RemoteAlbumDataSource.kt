package com.example.basicfragmenttests

class RemoteAlbumDataSource : AlbumDataSource {

    private val ALBUM_FAKE_DATA = LinkedHashMap<Int, Album>(AlbumDataInstance.dataSet.size)

    init{
        for(i in AlbumDataInstance.dataSet){
            addAlbum(i)
        }
    }

    private fun addAlbum(i: Album) {
        ALBUM_FAKE_DATA.put(i.id,i)
    }

    override fun getAlbum(id: Int): Album? {
        return ALBUM_FAKE_DATA[id]
    }

    override fun getAlbums(): ArrayList<Album> {
        return ArrayList(ALBUM_FAKE_DATA.values)
    }


}
