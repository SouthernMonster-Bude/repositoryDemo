using System.Collections;
using System.Collections.Generic;
using System.IO;
using UnityEngine;

public class SpriteManager : MonoBehaviour {
    public SpriteManager()
    {
    }
    public void AutoSetAtlas(string _atlasPath,string _texturePath)
    {
        AutoSetAtlasContent.AutoSetAtlasContents(_atlasPath, _texturePath);
    }


}
