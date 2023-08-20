object MimeTypes {
    fun mime() {
        val extensionInputs = listOf(
            "html",
            "png",
            "gif",
            "TXT"
        )

        val mimeInputs = listOf(
            "text/html",
            "image/png",
            "image/gif",
            "text/plain"
        )

        val fileInputs = listOf(
            "animated.gif",
            "portrait.png",
            "index.html",
            "pdf",
            "bla.TxT"
        )

        val extensionMimes = mutableListOf<Pair<String, String>>()

        for ((i, extension) in extensionInputs.withIndex()) {
            val EXT = extension
            val MT = mimeInputs[i]

            extensionMimes.add(Pair(EXT, MT))
        }

        val fileNames = mutableListOf<String>()

        for (file in fileInputs) {
            val FNAME = file // One file name per line.

            fileNames.add(FNAME)
        }

        val outputs = mutableListOf<String>()

        for (file in fileNames) {
            val extension = if (file.contains(".")) {
                file.split(".").lastOrNull()
            } else {
                null
            }

            val mimeType = extensionMimes.findLast { x -> x.first.lowercase().equals(extension?.lowercase()) }

            val output = if (extension.isNullOrBlank() || mimeType == null) {
                "UNKNOWN"
            } else {
                mimeType.second
            }

            outputs.add(output)
        }

        for (output in outputs) {
            println(output)
        }
    }

    fun mimeOptimized() {
        val extensionInputs = listOf(
            "html",
            "png",
            "gif",
            "TXT"
        )

        val mimeInputs = listOf(
            "text/html",
            "image/png",
            "image/gif",
            "text/plain"
        )

        val fileInputs = listOf(
            "animated.gif",
            "portrait.png",
            "index.html",
            "pdf",
            "bla.TxT"
        )

        val extensionMimes = mutableMapOf<String, String>()
        for ((i, extension) in extensionInputs.withIndex()) {
            val EXT = extension
            val MT = mimeInputs[i]

            extensionMimes[EXT.lowercase()] = MT
        }

        for (file in fileInputs) {
            val FNAME = file // One file name per line.

            val extension = FNAME.substringAfterLast(".", "").lowercase()
            val mimeType = extensionMimes[extension] ?: "UNKNOWN"
            println(mimeType)
        }
    }
}