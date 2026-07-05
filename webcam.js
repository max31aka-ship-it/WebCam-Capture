// webcam.js
#!/usr/bin/env node
'use strict';

const NodeWebcam = require('node-webcam');

function parseArgs() {
    const args = process.argv.slice(2);
    const opts = { output: 'snapshot.jpg', device: 0, delay: 0 };
    for (let i = 0; i < args.length; i++) {
        if (args[i] === '-o' && i+1 < args.length) opts.output = args[++i];
        else if (args[i] === '-d' && i+1 < args.length) opts.device = parseInt(args[++i], 10);
        else if (args[i] === '-t' && i+1 < args.length) opts.delay = parseInt(args[++i], 10);
        else if (args[i] === '-h' || args[i] === '--help') {
            console.log('Usage: node webcam.js [-o output] [-d device] [-t delay]');
            process.exit(0);
        }
    }
    return opts;
}

function capture(opts) {
    const Webcam = NodeWebcam.create({
        width: 1280,
        height: 720,
        quality: 100,
        output: "jpeg",
        device: opts.device === 0 ? false : opts.device,
        callbackReturn: "buffer"
    });

    if (opts.delay > 0) {
        console.log(`Ожидание ${opts.delay} секунд...`);
    }
    setTimeout(() => {
        Webcam.capture(opts.output, (err, data) => {
            if (err) {
                console.error("Ошибка захвата:", err);
                process.exit(1);
            } else {
                console.log(`✅ Изображение сохранено в ${opts.output}`);
            }
        });
    }, opts.delay * 1000);
}

const opts = parseArgs();
capture(opts);
