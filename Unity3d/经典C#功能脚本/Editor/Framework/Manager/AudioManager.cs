using System.Collections;
using System.Collections.Generic;
using System.IO;
using UnityEngine;

public class AudioManager : MonoBehaviour {
    private Dictionary<string, AudioClip> audioClipDict = new Dictionary<string, AudioClip>();
    private string savePath;
    private string filename;
    public AudioSource AudioSource;
    private bool isMute = false;
    public bool Mute{ get; set; }
    public AudioManager(){
        savePath = Application.dataPath + "/Framework/Res/";
        filename = savePath + "audioList.txt";
        LoadAudioClip();
    }
    private void LoadAudioClip()
    {
        Debug.Log("AudioManager LoadAudioClip");
        if (!File.Exists(filename)) return;
        string[] lines = File.ReadAllLines(filename);
        foreach (string line in lines)
        {
            Debug.Log("AudioManager line " + line);
            if (string.IsNullOrEmpty(line)) continue;
            string[] keyvalue = line.Split(':');
            AudioClip clip = Resources.Load<AudioClip>(keyvalue[1]);
            if (clip == null)
            {
                Debug.LogWarning("AudioClip " + keyvalue[1] + " loaded unsuccessfully");
            }
            audioClipDict.Add(keyvalue[0], clip);
        }
    }

    public void play(string name) {
        play(name, Vector3.zero);
    }
    public void play(string name,Vector3 position)
    {
        if (isMute) return;
        Debug.Log("AudioManager play " + name);
        AudioClip clip;
        audioClipDict.TryGetValue(name, out clip);
        if (clip == null)
        {
            Debug.LogWarning("AudioClip " + name + " opened unsuccessfully");
            return;
        }
        this.Stop(clip);
        AudioSource.PlayClipAtPoint(clip, position);
    }
    public void Stop(AudioClip clip)
    {
        AudioSource.clip = clip;
        AudioSource.Stop();
    }

}
