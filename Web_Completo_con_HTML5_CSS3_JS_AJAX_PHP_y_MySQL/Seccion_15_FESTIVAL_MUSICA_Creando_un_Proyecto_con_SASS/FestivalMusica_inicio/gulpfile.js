const {series, src, dest, watch, parallel} = require('gulp'); //require => forma de extraer de la carpeta node_modules, en este caso de la carpeta gulp y su funcionalidad
//src => identifica un archivo o varios de ellos. dest => guarda archvios

// CSS
const sass = require('gulp-sass')(require('sass'));
const autoprefixer = require ('autoprefixer');
// const cssnano = require ('cssnano')
// const postcss = require ('gulp-´postcss');

//IMAGENES
// const cache = require('gulp-cache');
// const imagemin = require('gulp-imagemin');
const webp = require ('gulp-webp');
const avif = require('gulp-avif');

//Watch ===> para no copilar a cada rato, y asignale la actulizacion

//funcion que compila SASS

function css() {
    return src('src/scss/app.scss')
        //pipe => accion que se realiza despues de otra
        .pipe( sass({               
            outputStyle: 'expanded'
        }))
        // .pipe ( postcss([ autoprefixer(), cssnano() ]))
        .pipe( dest('./build/css') )//ruta donde se guarda SASS copilado
}

function minificarcss() {
    return src('src/scss/app.scss')
        .pipe( sass({
            outputStyle: 'compressed'
        }))
        .pipe( dest('./build/css') )//ruta donde se guarda SASS copilado
}

function watchArchivos(){
    watch('src/scss/**/*.scss', css); // (* = la carpeta actual - ** = todos los archivos)
    watch('src/js/**/*.js', javascript);
}


// //reduciendo imagenes
// function imagenes (done){

//     const opciones = {
//         optimizationLevel: 3 //definiendo la calidad de la imagen
//     }
//     src('src/img/**/*.{png,jpg}')
//         .pipe( cache( imagemin(opciones) ) )
//         .pipe ( dest ('build/img'))
//     done();
// }



//Conviritendo imagenes a webp
function versionWebp (done){

    const opciones = {
        quality: 50 //definiendo la calidad de la imagen
    };

    //buscando la carpeta de imagenes
    src('src/img/**/*.{png,jpg}')
        .pipe( webp(opciones) )
        //almacenando las imagenes en el disco duro
        .pipe( dest('build/img') )

    done();
}

function versionAvif (done){

    const opciones = {
        quality: 50 //definiendo la calidad de la imagen
    };

    src('src/img/**/*.{png,jpg}')
        .pipe( avif(opciones) )
        .pipe( dest('build/img') )

    done();
}


function javascript(done){
    src('src/js/**/*.js')
    .pipe(dest('build/js'));

    done();
}


//COPILANDO => ctrl + c (detener copilacion)
exports.css = css;
exports.js = javascript
// exports.imagenes = imagenes;
exports.versionWebp = versionWebp;
exports.versionAvif = versionAvif;
// exports.dev = parallel(versionWebp, dev);
exports.minificarcss = minificarcss;

exports.watchArchivos = watchArchivos;


